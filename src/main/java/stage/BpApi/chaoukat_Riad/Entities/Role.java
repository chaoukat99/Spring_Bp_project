package stage.BpApi.chaoukat_Riad.Entities;

import jakarta.persistence.*;

@Entity
@Table(name="Roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false)
    private String name;

    @OneToOne(mappedBy = "role")
    private Client client;
    @OneToOne(mappedBy = "role")
    private Admin admin;

    public Role(){};


    public Role(String id, String name, Client client, Admin admin) {
        this.id = id;
        this.name = name;
        this.client = client;
        this.admin = admin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
