package com.kpi.jakartaeecource.servlet.converter;

import com.kpi.jakartaeecource.model.Member;
import com.kpi.jakartaeecource.servlet.dto.MemberDto;
import com.kpi.jakartaeecource.servlet.dto.ShortMemberInfoDto;

import java.util.List;
import java.util.stream.Collectors;

public final class MemberConverter {

    private MemberConverter() {
    }

    public static ShortMemberInfoDto toShortMemberInfo(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null");
        }

        return new ShortMemberInfoDto(
                member.getId(),
                member.getFirstName(),
                member.getLastName(),
                member.getJobTitle(),
                member.getAge());
    }

    public static List<ShortMemberInfoDto> toListDto(List<Member> members) {
        return members.stream().map(MemberConverter::toShortMemberInfo).collect(Collectors.toList());
    }

    public static MemberDto toMemberDto(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null");
        }

        return new MemberDto(
                member.getId(),
                member.getFirstName(),
                member.getLastName(),
                member.getAge(),
                member.getJobTitle(),
                member.getFullDescription(),
                member.getPhotoUrt()
                );
    }
}
