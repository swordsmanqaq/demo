package cn.henghuasoft.entity;


import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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
@Entity
@Table(name = "t_excel_database_excel_data")
public class ExcelData {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 年级编号
     */
    @NotBlank(message = "gradeNumber cannot be empty")
    @ExcelProperty("年级编号")
    @Column(name = "grade_number")
    private String gradeNumber;
    /**
     * 班级编号
     */
    @NotBlank(message = "classNumber cannot be empty")
    @ExcelProperty("班级编号")
    @Column(name = "class_number")
    private String classNumber;
    /**
     * 班级名称
     */
    @NotBlank(message = "className cannot be empty")
    @ExcelProperty("班级名称")
    @Column(name = "class_name")
    private String className;
    /**
     * 学籍号
     */
    @NotBlank(message = "schoolNumber cannot be empty")
    @ExcelProperty("学籍号")
    @Column(name = "school_number")
    private String schoolNumber;
    /**
     * 民族代码
     */
    @ExcelProperty("民族代码")
    @Column(name = "ethnic_code")
    private Integer ethnicCode;
    /**
     * 学生姓名
     */
    @NotBlank(message = "username cannot be empty")
    @ExcelProperty("姓名")
    @Column(name = "username")
    private String username;
    /**
     * 性别
     */
    @NotBlank(message = "sex cannot be empty")
    @ExcelProperty("性别")
    @Column(name = "sex")
    private String sex;
    /**
     * 身份证号
     */
    @NotBlank(message = "identificationCard cannot be empty")
    @ExcelProperty("身份证号")
    @Column(name = "identification_card")
    private String identificationCard;
    /**
     * 出生日期
     */
    @ExcelProperty("出生日期")
    @Column(name = "birth_date")
    private String birthDate;
    /**
     * 家庭住址
     */
    @ExcelProperty("家庭住址")
    @Column(name = "home_address")
    private String homeAddress;

}
