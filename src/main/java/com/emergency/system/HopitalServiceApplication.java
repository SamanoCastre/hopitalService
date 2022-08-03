package com.emergency.system;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.emergency.system.entities.Address;
import com.emergency.system.entities.Disponibilite;
import com.emergency.system.entities.Hopital;
import com.emergency.system.entities.Specialite;
import com.emergency.system.repositories.DisponibiliteRepository;
import com.emergency.system.repositories.HopitalRepository;
import com.emergency.system.repositories.SpecialiteRepository;
import com.emergency.system.services.ISequenceGeneratorService;

@EnableFeignClients
@SpringBootApplication
public class HopitalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HopitalServiceApplication.class, args);
	}
	/*
	@Bean
	CommandLineRunner start(SequenceGeneratorService sequenceGeneratorService, SpecialiteRepository specialiteRepository, HopitalRepository hopitalRepository, DisponibiliteRepository disponibiliteRepository, RepositoryRestConfiguration restConfiguration) {
		
		return args ->{
			restConfiguration.exposeIdsFor(Specialite.class);
			
			//suppression de tous les documents
			specialiteRepository.deleteAll();
			hopitalRepository.deleteAll();
			disponibiliteRepository.deleteAll();
			
			//Insertion des spécialités
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Anesthésie", "Anesthésie", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Anesthésie", "Soins intensifs", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Oncologie clinique", "Oncologie clinique", new Date()));
			
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe dentaire","Spécialités dentaires supplémentaires", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe dentaire","Radiologie dentaire et maxillo-faciale", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe dentaire","Endodontie", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe dentaire","Chirurgie buccale et maxillo-faciale", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe dentaire","Pathologie buccale et maxillo-faciale", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe dentaire","Médecine buccale", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe dentaire","Chriurgie buccale", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe dentaire","Orthodontie", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe dentaire","Dentisterie pédiatrique", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe dentaire","Parodontie", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe dentaire","Prosthodontie", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe dentaire","Dentisterie restauratrice", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe dentaire","Dentisterie de soins spéciaux", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Médecine d'urgence","Médecine d'urgence", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de médecine générale","Médecine interne de soins aigus", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de médecine générale","Allergie", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de médecine générale","Médecine audiovestibulaire", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de médecine générale","Cardiologie", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de médecine générale","Génétique clinique", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de médecine générale","Neurophysiologie clinique", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de médecine générale","Pharmacologie clinique et thérapeutique", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de médecine générale","Dermatologie", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de médecine générale","Endocrinologie et diabète sucré", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de médecine générale","Gastroentérologie", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de médecine générale","Médecine générale (interne)", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de médecine générale","Médecin généraliste", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de médecine générale","Médecine générale (GP) 6 mois", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de médecine générale","Médecine génito-urinaire", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de médecine générale","Médecine gériatrique", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de médecine générale","Maladies infectieuses", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de médecine générale","Oncologie médicale", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de médecine générale","Ophtalmologie médicale", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de médecine générale","Neurologie", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de médecine générale","Médecine du travail", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de médecine générale","Autre", new Date()));
			
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de médecine générale","Médecine palliative", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de médecine générale","Médecine de réadaptation", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de médecine générale","Médecine rénale", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de médecine générale","Médecine respiratoire", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de médecine générale","Rhumatologie", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de médecine générale","Médecine du sport et de l'exercice", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Obstétrique et gynécologie","Santé publique sexuelle et procréative", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe pédiatrique ","Cardiologie pédiatrique", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe pédiatrique ","Pédiatrie", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de pathologie","Pathologie chimique", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de pathologie","Neuropathologie diagnostique", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de pathologie","Histopathologie médico-légale", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de pathologie","Pathologie générale", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de pathologie","Hématologie", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de pathologie","Histopathologie", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de pathologie","Immunologie", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de pathologie","Microbiologie médicale", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de pathologie","Pathologie pédiatrique et périnatale", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de pathologie","Virologie", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe Pronostiques et gestion de la santé/Santé communautaire","Service de santé communautaire dentaire", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe Pronostiques et gestion de la santé/Santé communautaire","Service de santé communautaire médical", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe Pronostiques et gestion de la santé/Santé communautaire","Santé publique dentaire", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe Pronostiques et gestion de la santé/Santé communautaire","Praticien de l’art dentaire", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe Pronostiques et gestion de la santé/Santé communautaire","Santé publique", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de psychiatrie","Psychiatrie infantile et adolescente", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de psychiatrie","Psychiatrie légale", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de psychiatrie","Psychiatrie générale", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de psychiatrie","Psychiatrie de la vieillesse", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de psychiatrie","Psychiatrie des troubles d'apprentissage", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de psychiatrie","Psychothérapie", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de radiologie","Radiologie clinique", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe de radiologie","Médecine nucléaire", new Date()));
			
			
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe chirurgical","Chirurgie cardiothoracique", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe chirurgical","Chirurgie générale", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe chirurgical","Neurochirurgie", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe chirurgical","Ophtalmologie", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe chirurgical","Otolaryngologie", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe chirurgical","Chirurgie pédiatrique", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe chirurgical","Chirurgie plastique", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe chirurgical","Traumatologie et chirurgie orthopédique", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe chirurgical","Urologie", new Date()));
			specialiteRepository.save(new Specialite(sequenceGeneratorService.generateSequence(Specialite.SEQUENCE_NAME),"Groupe chirurgical","Chirurgie vasculaire", new Date()));
			
			//Insertion de 4 hopitaux
			restConfiguration.exposeIdsFor(Hopital.class);
			hopitalRepository.save(new Hopital(sequenceGeneratorService.generateSequence(Hopital.SEQUENCE_NAME),"Hopital de Purpan", new Address("1","place du Docteur Baylac","31059","Toulouse","France"), new Date()));
			hopitalRepository.save(new Hopital(sequenceGeneratorService.generateSequence(Hopital.SEQUENCE_NAME),"Hopital de rangueil", new Address("1","Av. du Professeur Jean Poulhès","31400","Toulouse", "France"), new Date()));
			hopitalRepository.save(new Hopital(sequenceGeneratorService.generateSequence(Hopital.SEQUENCE_NAME),"Hospitals Academics Paris Centre Ap-Hp",new Address("27", "Rue du Faubourg Saint-Jacques","75014", "Paris","France"), new Date()));
			hopitalRepository.save(new Hopital(sequenceGeneratorService.generateSequence(Hopital.SEQUENCE_NAME),"CHU de Bordeaux", new Address(null,"Pl. Amélie Raba Léon", "33000", "Bordeaux", "France"), new Date()));
			
			
			//Insertion des disponibilités (lits)
			restConfiguration.exposeIdsFor(Disponibilite.class);
			specialiteRepository.findAll().forEach(sp->{
				hopitalRepository.findAll().forEach(hp->{
				    disponibiliteRepository.save(new Disponibilite(sequenceGeneratorService.generateSequence(Disponibilite.SEQUENCE_NAME),hp, sp, 15, new Date()));
				});
			});
		};
	};*/

}
