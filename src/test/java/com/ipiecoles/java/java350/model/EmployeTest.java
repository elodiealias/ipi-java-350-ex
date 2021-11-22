package com.ipiecoles.java.java350.model;

import org.assertj.core.api.Assertions;
import org.junit.Assert;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

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





}