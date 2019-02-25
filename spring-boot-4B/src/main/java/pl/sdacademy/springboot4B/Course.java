package pl.sdacademy.springboot4B;

import lombok.Data;

@Data
class Course {
    private String name;
    private String location;
    private int membersCount;

//    Course() {
//    }
//
//    @Override
//    public String toString() {
//        return "Course{" +
//                "name='" + name + '\'' +
//                ", location='" + location + '\'' +
//                ", membersCount=" + membersCount +
//                '}';
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public int getMembersCount() {
//        return membersCount;
//    }
//
//    public void setMembersCount(int membersCount) {
//        this.membersCount = membersCount;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Course course = (Course) o;
//        return membersCount == course.membersCount &&
//                Objects.equals(name, course.name) &&
//                Objects.equals(location, course.location);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, location, membersCount);
//    }
}
