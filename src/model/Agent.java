package model;

public class Agent {
    private Integer agentId;
    private String firstName;
    private String midInitial;
    private String lastName;
    private String phone;
    private String email;
    private String position;
    private Integer agencyId;

    //constructor
    public Agent(Integer agentId, String firstName, String midInitial, String lastName, String phone, String email, String position, Integer agencyId) {
        this.agentId = agentId;
        this.firstName = firstName;
        this.midInitial = midInitial;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.position = position;
        this.agencyId = agencyId;
    }

    //getters and setters
    public Integer getAgentId() { return agentId; }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMidInitial() {
        return midInitial;
    }

    public void setMidInitial(String midInitial) {
        this.midInitial = midInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Integer agencyId) {
        this.agencyId = agencyId;
    }
}
