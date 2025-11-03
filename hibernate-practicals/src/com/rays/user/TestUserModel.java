package com.rays.user;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {

	public static void main(String[] args) {

		// testAdd();
		// testUpdate();
		// testDelete();
		// testGet();
		// testAuth();
		testSearch();

	}

	public static void testAdd() {

		UserDTO dto = new UserDTO();
		dto.setFirstName("Aniket");
		dto.setLastName("Rajput");
		dto.setLoginId("aniket@gmail.com");
		dto.setPassword("123");
		dto.setDob(new Date());
		dto.setAddress("Indore");

		UserModel model = new UserModel();
		model.add(dto);

	}

	public static void testUpdate() {

		UserDTO dto = new UserDTO();
		dto.setId(3);
		dto.setFirstName("Ani");
		dto.setLastName("Rajput");
		dto.setLoginId("aniket@gmail.com");
		dto.setPassword("123");
		dto.setDob(new Date());
		dto.setAddress("Indore");

		UserModel model = new UserModel();
		model.update(dto);

	}

	public static void testDelete() {
		UserDTO dto = new UserDTO();
		dto.setId(3);

		UserModel model = new UserModel();
		model.delete(dto);
	}

	public static void testGet() {

		UserModel model = new UserModel();
		UserDTO dto = model.get(1);

		System.out.println("\t" + dto.getFirstName());
		System.out.println("\t" + dto.getLastName());
		System.out.println("\t" + dto.getLoginId());
		System.out.println("\t" + dto.getPassword());
		System.out.println("\t" + dto.getDob());
		System.out.println("\t" + dto.getAddress());

	}

	public static void testAuth() {
		UserModel model = new UserModel();
		UserDTO dto = model.authenticate("ajay@gmail.com", "123");

		if (dto != null) {

			System.out.println("\t" + dto.getId());
			System.out.println("\t" + dto.getFirstName());
			System.out.println("\t" + dto.getLastName());
			System.out.println("\t" + dto.getLoginId());
			System.out.println("\t" + dto.getPassword());
			System.out.println("\t" + dto.getDob());
			System.out.println("\t" + dto.getAddress());

		} else {
			System.out.println("Auth failed");
		}

	}

	public static void testSearch() {
		UserDTO dto = new UserDTO();
		dto.setFirstName("Ajay");

		UserModel model = new UserModel();
		List list = model.search(dto, 0, 5);
		Iterator<UserDTO> it = list.iterator();

		while (it.hasNext()) {
			dto = it.next();

			System.out.println("\t" + dto.getId());
			System.out.println("\t" + dto.getFirstName());
			System.out.println("\t" + dto.getLastName());
			System.out.println("\t" + dto.getLoginId());
			System.out.println("\t" + dto.getPassword());
			System.out.println("\t" + dto.getDob());
			System.out.println("\t" + dto.getAddress());

		}

	}

}
