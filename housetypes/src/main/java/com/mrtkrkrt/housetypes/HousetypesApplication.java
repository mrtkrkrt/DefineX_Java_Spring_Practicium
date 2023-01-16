package com.mrtkrkrt.housetypes;

import com.mrtkrkrt.housetypes.dto.House;
import com.mrtkrkrt.housetypes.dto.IStructure;
import com.mrtkrkrt.housetypes.dto.Summery;
import com.mrtkrkrt.housetypes.dto.Villa;
import com.mrtkrkrt.housetypes.service.StructureService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HousetypesApplication {

	public static void main(String[] args) {

		List<IStructure> structures = new ArrayList<>();

		IStructure house1 = new House(35000, 85, "3+1");
		IStructure house2 = new House(40000, 90, "2+1");
		IStructure house3 = new House(45000, 95, "1+1");

		structures.add(house1);
		structures.add(house2);
		structures.add(house3);

		IStructure villa1 = new Villa(55000, 85, "5+1");
		IStructure villa2 = new Villa(75000, 55, "3+1");
		IStructure villa3 = new Villa(105000, 105, "8+2");

		structures.add(villa1);
		structures.add(villa2);
		structures.add(villa3);

		IStructure summery1 = new Summery(100000, 50, "2+1");
		IStructure summery2 = new Summery(120000, 55, "3+1");
		IStructure summery3 = new Summery(110000, 52, "2+1");

		structures.add(summery1);
		structures.add(summery2);
		structures.add(summery3);

//		SpringApplication.run(HousetypesApplication.class, args);
	}

}
