package college.dorm.mappertest;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import college.dorm.mapper.HouseparentMapper;
import college.dorm.pojo.Houseparent;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HouseparentMapperTest {
	@Autowired
	private HouseparentMapper hpm;

	@Test
	public void selectByHpId() {
		Houseparent houseparent = hpm.selectByHpid(1);
		System.err.println(houseparent.toString());
	}

	@Test
	public void selectByHpname() {
		Houseparent houseparent = hpm.selectByHpname("admin-okk");
		System.err.println(houseparent.toString());
	}

	@Test
	public void testInsertIntoHouseparent() {
		Houseparent hp = new Houseparent();

		hp.setHpname("admin-iii");
		hp.setPassword("iii");
		hp.setPortrait("problem10.jpg");
		hp.setCompetence(0);
		hp.setPhone("7891563");
		hp.setRegTime(new Date());
		hp.setSalt("asdas890nng4va");
		hp.setIsIncumbency(1);
		hp.setIdCard("8555555669002m");

		Integer effects = hpm.insertHouseparent(hp);
		System.err.println("effects:" + effects);
	}

	@Test
	public void testInsertMineHouseparentProfile() {
		Integer affect = hpm.updateOwnProfileByHpid("ohmineGOD", "81396121", "84casf.jpeg", 8);
		System.err.println("affect:" + affect);
	}

	@Test
	public void selectByIdCardTest() {
		Houseparent houseparent = hpm.selectByIdCard("18666666666");

		System.err.println("houseparent:" + houseparent);
	}

	@Test
	public void selectCountCompentenceTest() {
		Integer result = hpm.selectCountCompentence(1);

		System.err.println("result:" + result);
	}

	@Test
	public void updateisIncumbencyByHpidTest() {
		Integer result = hpm.updateisIncumbencyByHpidAndCompetence(7, 0, 1);
		System.err.println("result:" + result);

	}

	@Test
	public void updateCompetenceByHpidTest() {
		Integer result = hpm.updateCompetenceByHpid(8, 1);
		System.err.println("result:" + result);

	}

	@Test
	public void updatePasswordByIdCart() {
		Integer affect = hpm.updatePasswordByHpId(8, "uuuuu");
		System.err.println("affect:" + affect);
	}

	@Test
	public void deleteMultiByIdCart() {
		Integer[] ids = {9, 10, 11};

		Integer affects = hpm.deleteHouseparentByHpids(ids);
		System.err.println("results:" + affects);
	}

	@Test
	public void selectAllTest() {
		List<Houseparent> list = hpm.selectAllHouseparent();
		for (Houseparent houseparent : list) {
			System.err.println(houseparent.toString());
		}
	}

	@Test
	public void batchUpdateIsIncumbencyTest() {
		Integer[] hpids = {2, 3, 4, 5, 6, 7, 8};
		Integer rows = hpm.batchSetIsIncumbencyByHpid(0, hpids);
		System.err.println(rows);

	}

	@Test
	public void batchSetCompetenceByHpidTest() {
		Integer[] hpids = {15, 16, 17, 18};
		Integer rows = hpm.batchSetCompetenceByHpid(1, hpids);
		System.err.println(rows);
	}

	@Test
	public void batchDeleteByHpidTest() {
		Integer[] hpids = {3, 5};
		Integer rows = hpm.batchDeleteByHpids(hpids);
		System.err.println(rows);
	}

	@Test
	public void batchSelectByHpidsTest() {
		Integer[] hpids = {13, 14, 15};
		List<Houseparent> list = hpm.batchSelectHouseparent(hpids);

		for (Houseparent houseparent : list) {
			System.out.println(houseparent.getCompetence());
		}

	}

	@Test
	public void batchSelectCompetenceByHpidsTest() {
		Integer[] hpids = {13, 14, 15};
		Integer[] competences = hpm.batchSelectCompetenceHouseparent(hpids);

		for (int i = 0; i < competences.length; i++) {
			System.out.println(competences[i]);
		}

	}

	@Test
	public void updatePartialByHpidTest() {
		Integer effects = hpm.updatePartialByHpid("lockstone", "164987294864105", "451122198807192910", 15);

		System.out.println(effects);

	}

}
