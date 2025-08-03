package org.example.scheduleproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Schedule extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String userName;
    private String password;

    public Schedule(String title, String content, String userName, String password) {

        this.title = title;
        this.content = content;
        this.userName = userName;
        this.password = password;
    }

    public void changeTitle(String title) {
        this.title = title;
    }
    public void changeUserName(String userName) {
        this.userName = userName;
    }
}
