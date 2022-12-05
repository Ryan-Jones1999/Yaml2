package com.kainos.ea.service;

import com.kainos.ea.dao.JobDao;
import com.kainos.ea.exception.RoleNotAddedException;
import com.kainos.ea.model.JobRole;
import com.kainos.ea.model.NewRole;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class NewRoleServiceTest {

    JobDao jobDao = Mockito.mock(JobDao.class);

    @Test
    void getFamily_ShouldReturnFamily_whenDaoReturnsListOfFamilys() throws SQLException {
        JobRole result = new JobRole(1, "This is a test");
        JobRole result2 = new JobRole(2, "This is a test2");
        List<JobRole> expected = new ArrayList<>();

        expected.add(result);
        expected.add(result2);

        Mockito.when(jobDao.populateFamilyLists()).thenReturn(expected);

        List<JobRole> actual;
        actual = jobDao.populateFamilyLists();

        assertEquals(expected.get(1).getListName(),actual.get(1).getListName());
    }

    @Test
    void getFamily_shouldThrowSQLException_whenDaoThrowsSqlException() throws SQLException {
        Mockito.when(jobDao.populateFamilyLists()).thenThrow(SQLException.class);

        assertThrows(SQLException.class,
                () -> jobDao.populateFamilyLists());
    }

    @Test
    void getBand_ShouldReturnBands_whenDaoReturnsListOfBands() throws SQLException {
        JobRole result = new JobRole(1, "This is a test");
        JobRole result2 = new JobRole(2, "This is a test2");
        List<JobRole> expected = new ArrayList<>();

        expected.add(result);
        expected.add(result2);

        Mockito.when(jobDao.populateBandLevelList()).thenReturn(expected);

        List<JobRole> actual;

        actual = jobDao.populateBandLevelList();

        assertEquals(expected.get(0).getListName(),actual.get(0).getListName());
    }

    @Test
    void getBands_shouldThrowSQLException_whenDaoThrowsSqlException() throws SQLException {
        Mockito.when(jobDao.populateBandLevelList()).thenThrow(SQLException.class);

        assertThrows(SQLException.class,
                () -> jobDao.populateBandLevelList());
    }

    @Test
    void getCapability_ShouldReturnCapability_whenDaoReturnsListOfCapabilities() throws SQLException {
        JobRole result = new JobRole(1, "This is a test");
        JobRole result2 = new JobRole(2, "This is a test2");
        List<JobRole> expected = new ArrayList<>();

        expected.add(result);
        expected.add(result2);

        Mockito.when(jobDao.getjobwithcapability()).thenReturn(expected);

        List<JobRole> actual;

        actual = jobDao.getjobwithcapability();

        assertEquals(expected.get(0).getListID(),actual.get(0).getListID());
    }

    @Test
    void getCapability_shouldThrowSQLException_whenDaoThrowsSqlException() throws SQLException {
        Mockito.when(jobDao.populateCapabilityList()).thenThrow(SQLException.class);

        assertThrows(SQLException.class,
                () -> jobDao.populateCapabilityList());
    }

    @Test
    void postAddNewRole_ShouldReturnNewRole_whenDaoReturnsNewRole() throws SQLException, RoleNotAddedException {

        NewRole newrole = new NewRole(
                "This is a test",
                "This is a test",
                "This is also a test",
                1,
                1,
                1
        );

        Mockito.when(jobDao.postNewjobrole(newrole)).thenReturn(newrole);

        NewRole actual;

        actual = jobDao.postNewjobrole(newrole);

        assertEquals(newrole,actual);
    }

    @Test
    void postAddNewRole_ShouldReturnSQLException_whenDaoReturnsSQLException() throws SQLException, RoleNotAddedException {

        NewRole newrole = new NewRole(
                "This is a test",
                "This is a test",
                "This is also a test",
                1,
                1,
                1
        );
        Mockito.when(jobDao.postNewjobrole(newrole)).thenThrow(SQLException.class);

        assertThrows(SQLException.class,
                () -> jobDao.postNewjobrole(newrole));
    }

    @Test
    void postAddNewRole_ShouldReturnRoleNotAddedException_whenDaoReturnsRoleNotAddedException() throws SQLException, RoleNotAddedException {

        NewRole newrole = new NewRole(
                "This is a test",
                "This is a test",
                "This is also a test",
                1,
                1,
                1
        );
        Mockito.when(jobDao.postNewjobrole(newrole)).thenThrow(RoleNotAddedException.class);

        assertThrows(RoleNotAddedException.class,
                () -> jobDao.postNewjobrole(newrole));
    }
}
