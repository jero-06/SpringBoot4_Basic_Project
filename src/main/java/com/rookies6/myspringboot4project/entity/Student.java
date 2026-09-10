package com.rookies6.myspringboot4project.entity;

import jakarta.persistence.*;
import lombok.*;

//Student
@Entity
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String studentNumber;

    //1:1 지연로딩
    //mappedBy 에는 상대 엔티티(StudentDetail)에 있는 필드명을 적는다
    //cascade = ALL : Student 저장/삭제 시 StudentDetail 도 함께 처리된다
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "student", cascade = CascadeType.ALL)
    private StudentDetail studentDetail;

    //N:1 Student와 Department 관계에서 N쪽에 해당하는 Student가 Owner이다.
    //FK 에 매핑되는 필드
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

}