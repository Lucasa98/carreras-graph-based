package com.lucas.carreras;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import com.lucas.carreras.node.Carrera;
import com.lucas.carreras.node.Materia;
import com.lucas.carreras.repository.CarreraRepository;
import com.lucas.carreras.repository.MateriaRepository;

@SpringBootApplication
@EnableNeo4jRepositories
public class CarrerasApplication {
	private final static Logger log = LoggerFactory.getLogger(CarrerasApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CarrerasApplication.class, args);
		System.exit(0);
	}

	@Bean
	CommandLineRunner demo(CarreraRepository carreraRepository, MateriaRepository materiaRepository) {
		return args -> {
			carreraRepository.deleteAll();
			materiaRepository.deleteAll();

			// Carreras
			Carrera inf = new Carrera("Ingenieria en Informatica", 2006);
			Carrera amb = new Carrera("Ingenieria Ambientla", 2006);

			List<Carrera> carreras = Arrays.asList(inf, amb);

			Materia calculo1 = new Materia("Calculo 1");
			Materia calculo2 = new Materia("Calculo 2");
			Materia quimica = new Materia("quimica");
			Materia programacion = new Materia("programacion");

			List<Materia> materias = Arrays.asList(calculo1, calculo2, quimica, programacion);

			log.info("Before linking up with Neo4j...");

			// listar carreras y materias
			log.info("Carreras:");
			carreras.stream().forEach(carrera -> log.info("\t" + carrera.toString()));
			log.info("Materias:");
			materias.stream().forEach(materia -> log.info("\t" + materia.toString()));

			// guardar carreras y materias
			carreraRepository.save(inf);
			carreraRepository.save(amb);
			materiaRepository.save(calculo1);
			materiaRepository.save(calculo2);
			materiaRepository.save(quimica);
			materiaRepository.save(programacion);

			// Relacionar materias y carreras
			inf = carreraRepository.findByNombre(inf.getNombre());
			inf.dicta(calculo1, 6, 2);
			inf.dicta(calculo2, 10, 3);
			inf.dicta(programacion, 4, 1);
			amb = carreraRepository.findByNombre(amb.getNombre());
			amb.dicta(calculo1, 6, 2);
			amb.dicta(calculo2, 10, 3);
			amb.dicta(quimica, 3, 1);

			carreraRepository.save(inf);
			carreraRepository.save(amb);

			// Mostrar materias por cada carrera
			inf = carreraRepository.findByNombre(inf.getNombre());
			amb = carreraRepository.findByNombre(amb.getNombre());
			carreras = Arrays.asList(inf, amb);
			log.info("Materias por carrera...");
			carreras.stream().forEach(carrera -> {
				log.info(carrera.toString());
				carrera.materias.stream().forEach(materiaDictada -> {
					log.info("\t" + materiaDictada.toString());
				});
			});
		};
	}
}
