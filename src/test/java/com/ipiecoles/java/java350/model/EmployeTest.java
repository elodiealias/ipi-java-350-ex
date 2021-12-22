package com.ipiecoles.java.java350.model;

import org.assertj.core.api.Assertions;
import org.junit.Assert;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runners.Parameterized;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EmployeTest {

    @Test
    void getNombreAnneeAncienneteNow() {
        //Given
        Employe employe = new Employe("Dupont","Julien","T12345", LocalDate.now(), 2500.0, 1, 1.0);
        //When
        Integer nbAnnees = employe.getNombreAnneeAnciennete();
        //Then
        Assertions.assertThat(nbAnnees).isEqualTo(0);

    }
    @Test
    void getNombreAnneeAncienneteNull() {
        //Given
        Employe employe = new Employe("Dupont","Julien","T12345",null, 2500.0, 1, 1.0);
        //When
        Integer nbAnnees = employe.getNombreAnneeAnciennete();
        //Then
        Assertions.assertThat(nbAnnees).isEqualTo(null);

    }


    @Test
    void getNombreAnneeAncienneteSup() {
        //Given
        Employe employe = new Employe("Dupont","Julien","T12345", LocalDate.now().plusYears(8), 2500.0, 1, 1.0);
        //When
        Integer nbAnnees = employe.getNombreAnneeAnciennete();
        //Then
        Assertions.assertThat(nbAnnees).isEqualTo(null);

    }
    @Test
    void getNombreAnneeWithPastAnciennete() {
        //Given
        Employe employe = new Employe("Dupont","Julien","T12345", LocalDate.now().minusYears(2), 2500.0, 1, 1.0);
        //When
        Integer nbAnnees = employe.getNombreAnneeAnciennete();
        //Then
        Assertions.assertThat(nbAnnees).isEqualTo(2);

    }

    @Test
    void getPrimeAnnuelle() {
        //Given
        Employe employe = new Employe("Dupont","Julien","M12345",LocalDate.now() ,2500.0, 1,1.0 );
        //When
        Double prime = employe.getPrimeAnnuelle();
        //Then
        Assertions.assertThat(prime).isEqualTo(1700d);
    }

    @ParameterizedTest(name = "matricule {0}, performance{1},tempsPartiel{2}, primeAnciennete{3} => prime{4} " )
    @CsvSource({
            "M12345,3, 1, 1.0, 1700.0",
            "M12345,0, 1, 0.5, 850.0",
            "M12345,1, 1, 1.0, 1800.0",
            "'T12345', 0,1,1.0,1000.0",
            "'T12345', 0,0,1.0,1000.0",
    })
    void TestgetPrimeAnnuelle(String matricule, Integer nbAnneeAnciennete, Integer performance, Double tempsPartiel, Double primeCalculee){
        //Given, When, Then
        //Matricule, DateEmbauche,Performance, TempsPartiel
        Employe employe = new Employe("Dupont","Julien",matricule, LocalDate.now().minusYears(nbAnneeAnciennete),2500.0, performance,tempsPartiel);

        Assertions.assertThat(primeCalculee).isEqualTo(primeCalculee);

    }
    @Test
    void getAugmenterSalaire() {
        //Given
        Employe employe = new Employe("Dupont","Julien","M12345",LocalDate.now() ,1000.0, 1,1.0 );
        //When
        Double augmentation = employe.AugmenterSalaire(2.0);
        //Then
        Assertions.assertThat(augmentation).isEqualTo(1020.0);
    }

    @Test
    void getAugmenterSalaireAZero() {
        //Given
        Employe employe = new Employe("Dupont","Julien","M12345",LocalDate.now() ,0.0, 1,1.0 );
        //When
        Double augmentation = employe.AugmenterSalaire(20.0);
        //Then
        Assertions.assertThat(augmentation).isEqualTo(0);
    }

    @Test
    void getAugmenterSalaireNull() {
    //Given
        Employe employe = new Employe("Dupont","Julien","M12345",LocalDate.now() ,null, 1,1.0 );
    //When
        Double augmentation = employe.AugmenterSalaire(20.0);
    //Then
        Assertions.assertThat(employe.getSalaire()).isNull();
    }

    @Test
    void getAugmenterSalairePourcentZero() {
        //Given
        Employe employe = new Employe("Dupont","Julien","M12345",LocalDate.now() ,1000.0, 1,1.0 );
        //When
        Double augmentation = employe.AugmenterSalaire(0.0);
        //Then
        Assertions.assertThat(augmentation).isEqualTo(1000);
    }

    @Test
    void getAugmenterSalaireNegatif() {
        //Given
        Employe employe = new Employe("Dupont","Julien","M12345",LocalDate.now() ,-1000.0, 1,1.0 );
        //When
        Double augmentation = employe.AugmenterSalaire(20.0);
        //Then
        Assertions.assertThat(augmentation).isEqualTo(-1200);
    }





}