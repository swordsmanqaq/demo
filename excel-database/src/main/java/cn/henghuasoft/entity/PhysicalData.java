package cn.henghuasoft.entity;


import java.util.Date;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author Jarvis-Smith
 * @since 2023-07-29
 * @Description: PhysicalData体测数据实体类
 */
@Data
public class PhysicalData {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;
    /**
     * 年级编号
     */
    private Long gradeNumber;
    /**
     * 班级编号
     */
    private Long classNumber;
    /**
     * 班级名称
     */
    private String className;
    /**
     * 学籍号
     */
    private Long schoolNumber;
    /**
     * 民族代码
     */
    private Integer ethnicCode;
    /**
     * 学生姓名
     */
    private String username;
    /**
     * 性别
     */
    private String sex;
    /**
     * 身份证号
     */
    private String identificationCard;
    /**
     * 出生日期
     */
    private Date birthDate;
    /**
     * 家庭住址
     */
    private String homeAddress;
    /**
     * 身高
     */
    private Float height;
    /**
     * 体重
     */
    private Float weigth;
    /**
     * 体重评分
     */
    private Integer weigthScore;
    /**
     * 体重等级
     */
    private String weigthLevel;
    /**
     * 肺活量
     */
    private Integer vitalCapacity;
    /**
     * 肺活量评分
     */
    private Integer vitalCapacityScore;
    /**
     * 肺活量等级
     */
    private String vitalCapacityLevel;
    /**
     * 五十米跑
     */
    private Float fiftyMeters;
    /**
     * 五十米跑评分
     */
    private Integer fiftyMetersScore;
    /**
     * 五十米跑等级
     */
    private String fiftyMetersLevel;
    /**
     * 立定跳远
     */
    private Float standingJump;
    /**
     * 立定跳远评分
     */
    private Integer standingJumpScore;
    /**
     * 立定跳远等级
     */
    private String standingJumpLevel;
    /**
     * 坐位体前屈
     */
    private Float sitForwardBend;
    /**
     * 坐位体前屈评分
     */
    private Integer sitForwardBendScore;
    /**
     * 坐位体前屈等级
     */
    private String sitForwardBendLevel;
    /**
     * 八百米跑
     */
    private Date eightHundredMeters;
    /**
     * 八百米跑评分
     */
    private Integer eightHundredMetersScore;
    /**
     * 八百米跑等级
     */
    private String eightHundredMetersLevel;
    /**
     * 八百米跑附加分
     */
    private Integer eightHundredMetersExtraScore;
    /**
     * 一千米跑
     */
    private Date kilometre;
    /**
     * 一千米跑评分
     */
    private Integer kilometreScore;
    /**
     * 一千米跑等级
     */
    private String kilometreLevel;
    /**
     * 一千米跑附加分
     */
    private Integer kilometreExtraScore;
    /**
     * 一分钟仰卧起坐
     */
    private Integer oneMuniteSitUps;
    /**
     * 一分钟仰卧起坐评分
     */
    private Integer oneMuniteSitUpsScore;
    /**
     * 一分钟仰卧起坐等级
     */
    private String oneMuniteSitUpsLevel;
    /**
     * 一分钟仰卧起坐附加分
     */
    private Integer oneMuniteSitUpsExtraScore;
    /**
     * 引体向上
     */
    private Integer pullUp;
    /**
     * 引体向上评分
     */
    private Integer pullUpScore;
    /**
     * 引体向上等级
     */
    private String pullUpLevel;
    /**
     * 引体向上附加分
     */
    private Integer pullUpExtraScore;
    /**
     * 标准分
     */
    private Float standardScore;
    /**
     * 附加分
     */
    private Integer extraScore;
    /**
     * 总分
     */
    private Float totalScore;
    /**
     * 总分等级
     */
    private String totalScoreLevel;
    /**
     * 备注
     */
    private String remark;
}
