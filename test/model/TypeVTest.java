package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TypeVTest {

	public void setupScenary5() {
	}
	
	@Test
	void testTypeV() {
		int quality = 100;
		int codeTv = 1;
		String nameTv = "Deportivo";
		int refTv = 0;
		
		TypeV newTypeV = new TypeV(quality, refTv, codeTv, nameTv);
		
		assertEquals(quality, newTypeV.getQuality());
		assertEquals(codeTv, newTypeV.getCodeA());
		assertEquals(nameTv, newTypeV.getNameTB());
		assertEquals(refTv, newTypeV.getRefTv());
	}

}
