package main.java.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TYPE_OF_CLIENT database table.
 * 
 */
@Entity
@Table(name="TYPE_OF_CLIENT")
@NamedQuery(name="TypeOfClient.findAll", query="SELECT t FROM TypeOfClient t")
public class TypeOfClient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CT_ID")
	private int ctId;

	@Column(name="CT_NAME")
	private String ctName;

	//bi-directional many-to-one association to Client
	@OneToMany(mappedBy="typeOfClient")
	private List<Client> clients;

	public TypeOfClient() {
	}

	public int getCtId() {
		return this.ctId;
	}

	public void setCtId(int ctId) {
		this.ctId = ctId;
	}

	public String getCtName() {
		return this.ctName;
	}

	public void setCtName(String ctName) {
		this.ctName = ctName;
	}

	public List<Client> getClients() {
		return this.clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Client addClient(Client client) {
		getClients().add(client);
		client.setTypeOfClient(this);

		return client;
	}

	public Client removeClient(Client client) {
		getClients().remove(client);
		client.setTypeOfClient(null);

		return client;
	}

}