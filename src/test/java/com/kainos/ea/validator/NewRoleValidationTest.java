package com.kainos.ea.validator;

import com.kainos.ea.model.NewRole;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class NewRoleValidationTest {

    NewJobRoleValidation validator = new NewJobRoleValidation();

    @Test
    public void isValidNewRole_shouldReturnTrue_whenValidRole(){
        NewRole newrole = new NewRole(
                "This is a test",
                "This is a test",
                "This is also a test",
                1,
                1,
                1
        );

        assertTrue(validator.NewRoleValidation(newrole));
    }

    @Test
    public void isValidNewRole_shouldReturnFalse_whenJobNameLessThan5Characters(){
        NewRole newrole = new NewRole(
                "Ths",
                "This is a test",
                "This is also a test",
                1,
                1,
                1
        );

        assertFalse(validator.NewRoleValidation(newrole));
    }

    @Test
    public void isValidNewRole_shouldReturnFalse_whenJobResponsibilityLessThan10Characters(){
        NewRole newrole = new NewRole(
                "This is a test",
                "This",
                "This is also a test",
                1,
                1,
                1
        );

        assertFalse(validator.NewRoleValidation(newrole));
    }

    @Test
    public void isValidNewRole_shouldReturnFalse_whenSpecificationSummaryLessThan8Characters(){
        NewRole newrole = new NewRole(
                "This is a test",
                "This is test sss",
                "This",
                1,
                1,
                1
        );

        assertFalse(validator.NewRoleValidation(newrole));
    }

    @Test
    public void isValidNewRole_shouldReturnFalse_whenBandLevelLessthan1(){
        NewRole newrole = new NewRole(
                "This is a test",
                "This is test sss",
                "This ist dsfdsfdsdfs",
                1,
                0,
                1
        );

        assertFalse(validator.NewRoleValidation(newrole));
    }

    @Test
    public void isValidNewRole_shouldReturnFalse_whenCapabilityLevelLessThan1(){
        NewRole newrole = new NewRole(
                "This is a test",
                "This is test sss",
                "This ist dsfdsfdsdfs",
                1,
                1,
                -1
        );

        assertFalse(validator.NewRoleValidation(newrole));
    }

    @Test
    public void isValidNewRole_shouldReturnFalse_whenJobFamilyLevelLessThan1(){
        NewRole newrole = new NewRole(
                "This is a test",
                "This is test sss",
                "This ist dsfdsfdsdfs",
                -10,
                1,
                1
        );

        assertFalse(validator.NewRoleValidation(newrole));
    }
}