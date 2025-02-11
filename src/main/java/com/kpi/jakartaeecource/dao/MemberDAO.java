package com.kpi.jakartaeecource.dao;

import com.kpi.jakartaeecource.model.Member;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class MemberDAO {

    private final List<Member> members = new ArrayList<>();

    public MemberDAO() {
        initSampleData();
    }

    public List<Member> getAllMembers() {
        return members;
    }

    public Member getMemberById(int id) {
        return members.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
    }

    private void initSampleData() {
        members.add(new Member(1, "Dmytro", "Kovbasa", 28, "Dev", "Citizen of this world, software engineer.", ""));
        members.add(new Member(2, "Artur", "Lavrov", 28, "Dev", "Citizen of this world, software engineer.", ""));
        members.add(new Member(3, "Dmytro", "Meheda", 24, "Dev",
                "Dmytro Meheda is a skilled software developer with a strong background in .NET (C#) development and a growing interest in Kotlin.", ""));
    }
}
