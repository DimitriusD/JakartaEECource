package com.kpi.jakartaeecource.dao;

import com.kpi.jakartaeecource.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    private static final List<Member> MEMBERS = new ArrayList<>();

    static {
        MEMBERS.add(new Member(
                1,
                "Dmytro",
                "Kovbasa",
                28,
                "Dev",
                ""

        ));
        MEMBERS.add(new Member(
                2,
                "Artur",
                "Lavrov",
                28,
                "Dev",
                ""
        ));
        MEMBERS.add(new Member(
                3,
                "Dmytro",
                "Megeda",
                28,
                "Dev",
                ""
        ));
    }

    public List<Member> getAllMembers() {
        return MEMBERS;
    }

    public Member getMemberById(int id) {
        for (Member m : MEMBERS) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }
}