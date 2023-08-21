package cn.henghuasoft.listener;/**
 * @author shkstart
 * @create 2023-08-02 23:14
 */

import cn.henghuasoft.entity.ExcelData;
import cn.henghuasoft.repository.ExcelDataRepository;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

/**
 * @Auther:Jarvis
 * @Date:2023年08月2023/8/2日23:14
 * @Description: Excel 监听器
 */
@Slf4j
@Component
public class ExcelListener implements ReadListener<ExcelData> {

    private ExcelDataRepository excelDataRepository;

    private static final Integer BATCH_COUNT = 100;
    // 创建固定大小的数组
    private List<ExcelData> dataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    // 创建 Validator 对象
    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public ExcelListener() {

    }

    public ExcelListener(ExcelDataRepository excelDataRepository) {
        this.excelDataRepository = excelDataRepository;
    }

    /**
     * 读取每一行数据时调用
     *
     * @param physicalData    one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param analysisContext analysis context
     */
    @Override
    public void invoke(ExcelData physicalData, AnalysisContext analysisContext) {
        // 参数校验
        Set<ConstraintViolation<ExcelData>> validate = validator.validate(physicalData);
        if (!validate.isEmpty()) {
            // 参数校验失败
            throw new RuntimeException("Invalid data found in the Excel file");
        }

        log.info("解析到一条数据:{}", JSON.toJSONString(physicalData));

        // 添加 Excel 读取的数据到数据当中
        dataList.add(physicalData);
        if (dataList.size() >= BATCH_COUNT) {
            // 保存数据
            excelDataRepository.saveAll(dataList);
            // 清空数组
            dataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }

    }

    /**
     * 所有数据读取完毕调用
     *
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        excelDataRepository.saveAll(dataList);
        log.info("successfully");
    }


}
