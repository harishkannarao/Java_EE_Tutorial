package firstcup.dukesage.resource;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User {

    @XmlElement(name = "ID")
    private Long id;
    @XmlElement(name = "UserName")
    private String username;
    @XmlElement(name = "Name")
    private Name name;
    @XmlElement(name = "Address")
    private Address address;
    @XmlElement(name = "Contacts")
    private List<Contact> contacts;
    @XmlElement(name = "Skills")
    private String[] skills;
    @XmlTransient
    private String ignoredField;

    public User() {
    }

    public User(Long id, String username, Name name, Address address, List<Contact> contacts, String[] skills, String ignoredField) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.address = address;
        this.contacts = contacts;
        this.skills = skills;
        this.ignoredField = ignoredField;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    public String getIgnoredField() {
        return ignoredField;
    }

    public void setIgnoredField(String ignoredField) {
        this.ignoredField = ignoredField;
    }
}
