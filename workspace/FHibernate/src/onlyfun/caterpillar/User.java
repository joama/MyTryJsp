package onlyfun.caterpillar;

public class User {
	private Long id;
    private String name;
    private Long age;
 
    // �����n���@�ӹw�]���غc��k
    // �H�ϱoHibernate�i�H�ϥ�Constructor.newInstance()�إߪ���
    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
 
    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
