package nedis.study.jee.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the test database table.
 * 
 */
@Entity
@Table(name="test", schema = "xgbua_web_tester")
public class Test extends AbstractEntity  {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TEST_IDTEST_GENERATOR", sequenceName="TEST_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TEST_IDTEST_GENERATOR")
	@Column(name="id_test", unique=true, nullable=false)
	private Long idTest;

	@Column(name="active",nullable=false)
	private Boolean active;

	@Column(name="created",nullable=false)
	private Timestamp created;

	@Column(name="description",length=2147483647)
	private String description;

	@Column(name="time_per_question", nullable=false)
	private Integer periodPerQuestion;

	@Column(name="name",nullable=false, length=100)
	private String title;
	@Column(name="updated")
	private Timestamp updated;


	//bi-directional many-to-one association to Question
	@OneToMany(mappedBy="test")
	@OrderBy("created")
	private List<Question> questions;

	//bi-directional many-to-one association to Account
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_account", nullable=false)
	private Account account;

    public Test() {
    }

	public Long getIdTest() {
		return this.idTest;
	}
	
	@Override
	@Transient
	public Serializable getId() {
		return getIdTest();
	}

	public void setIdTest(Long idTest) {
		this.idTest = idTest;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPeriodPerQuestion() {
		return this.periodPerQuestion;
	}

	public void setPeriodPerQuestion(Integer periodPerQuestion) {
		this.periodPerQuestion = periodPerQuestion;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getUpdated() {
		return this.updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}


	
	public List<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
}