package family_tree.family_tree;

import family_tree.human.Human;
import family_tree.human.comparators.HumanComparatorByBirthDate;
import family_tree.human.comparators.HumanComparatorByName;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> humanList;

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }
    public FamilyTree() {
        this(new ArrayList<>());
    }

    public void add(Human human) {
        humanList.add(human);
        addToParents(human);
        addToChildren(human);
    }

    private void addToParents(Human human) {
        if (human.getParents() != null) {
            for (Human parent : human.getParents()) {
                parent.addChild(human);
            }
        }
    }

    private void addToChildren(Human human) {
        if (human.getChildren() != null) {
            for (Human child : human.getChildren()) {
                child.addParent(human);
            }
        }
    }

    public Human getByName(String name) {
        for (Human human: humanList) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (Human human: humanList) {
            sb.append(human.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }

    public void sortByName() {
        humanList.sort(new HumanComparatorByName());
    }
    public void sortByBirthDate() {
        humanList.sort(new HumanComparatorByBirthDate());
    }
}