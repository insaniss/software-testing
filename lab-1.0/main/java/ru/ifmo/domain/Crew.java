package ru.ifmo.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Crew {
    private final List<Human> members = new ArrayList<>();

    public Crew() {
    }

    public Crew(Collection<Human> members) {
        this.members.addAll(members);
    }

    public int numberOfMembers() {
        return members.size();
    }

    public void addMember(Human human) {
        this.members.add(human);
    }

    public void removeMember(Human human) {
        this.members.remove(human);
    }
}
