package family_tree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    String name;
    Sex sex;
    LocalDate birthDate;
    LocalDate deathDate;
    List<Human> parents;
    List<Human> children;

    public Human(String name, Sex sex, LocalDate birthDate, LocalDate deathDate, List<Human> parents) {
        this.parents = new ArrayList<>();

        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.parents = parents;
        children = new ArrayList<>();
    }
    public Human(String name, Sex sex, LocalDate birthDate) {
        this(name, sex, birthDate, null,new ArrayList<>());
    }
    public Human(String name, Sex sex, LocalDate birthDate, List<Human> parents) {
        this(name, sex, birthDate, null, parents);
    }
    public void addChild(Human child) {
        children.add(child);
    }
    public void addParent(Human parent) {
        parents.add(parent);
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ");
        sb.append(name);
        sb.append(", пол: ");
        sb.append(sex);
        sb.append(", дата рождения: ");
        sb.append(birthDate);
        if (deathDate != null) {
            sb.append(", дата смерти: ");
            sb.append(deathDate);
        }
        sb.append(", ");
        sb.append(getParentsInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    public String getParentsInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("родители: ");
        if (!parents.isEmpty()) {
            sb.append(parents.get(0).getName());
            for (int i = 1; i < parents.size(); i++) {
                sb.append(", ").append(parents.get(i).getName());
            }
        } else {
            sb.append("Неизвестны");
        }
        return sb.toString();
    }

    public String getChildrenInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("дети: ");
        if (!children.isEmpty()) {
            sb.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                sb.append(", ").append(children.get(i).getName());
            }
        } else {
            sb.append("Отсутствуют");
        }
        return sb.toString();
    }


    ////////////////////Getter////////////////
    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public List<Human> getParents() {
        return parents;
    }

    public List<Human> getChildren() {
        return children;
    }
    ////////////////////////////////////////////

}