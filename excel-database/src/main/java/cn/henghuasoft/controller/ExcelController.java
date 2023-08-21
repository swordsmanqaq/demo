package cn.henghuasoft.controller;/**
 * @author shkstart
 * @create 2023-08-02 00:22
 */

import cn.henghuasoft.entity.ExcelData;
import cn.henghuasoft.exception.ResponseCode;
import cn.henghuasoft.listener.ExcelListener;
import cn.henghuasoft.repository.ExcelDataRepository;
import cn.henghuasoft.util.AjaxResult;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ClassUtils;
import com.alibaba.excel.util.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.sl.draw.geom.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.InputStream;
import java.util.List;


/**
 * @Auther:Jarvis
 * @Date:2023年08月2023/8/2日00:22
 * @Description: Excel功能接口
 */
@RestController
@RequestMapping("/excel")
@Slf4j
public class ExcelController {

    @Autowired
    private ExcelDataRepository excelDataRepository;

    /**
     * Excel 导入接口
     *
     * @param file 用来接受Excel文件
     * @return
     */
    @PostMapping("/import")
    public AjaxResult importExcel(@RequestParam("file") MultipartFile file) {
        try (InputStream inputStream = file.getInputStream()) {
            ExcelListener excelListener = new ExcelListener(excelDataRepository);
            // 调用 Excel read 方法
            EasyExcel.read(inputStream, ExcelData.class, excelListener).sheet().doRead();
            return AjaxResult.me().setMessage("Data imported successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage(ResponseCode.RESPONSE_CODE_400.getMessage()).setCode(ResponseCode.RESPONSE_CODE_400.getCode());
        }
    }

    /**
     * Excel 导出接口
     *
     * @return
     */
    @GetMapping("export")
    public AjaxResult exportExport(HttpServletResponse response) {
        try {
//            ServletOutputStream outputStream = response.getOutputStream();
            String outputPath = "/Users/jarvis/Downloads/export.xlsx";
            File outputStream = new File(outputPath);
            // 获取数据库中所有的数据
            List<ExcelData> excelData = excelDataRepository.findAll();
            // 调用 Excel write 方法
            EasyExcel.write(outputStream, ExcelData.class).sheet("sheet1").doWrite(excelData);
            return AjaxResult.me().setMessage("Data exported successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage(ResponseCode.RESPONSE_CODE_500.getMessage()).setCode(ResponseCode.RESPONSE_CODE_500.getCode());
        }
    }

}
