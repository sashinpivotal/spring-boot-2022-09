package com.example.demodi3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EmployeeTest {

    @Mock
    private IAddress address;

    @Test
    void getEmployeeInfo_should_return_uppercased_name_and_address() {

        // arrange
        BDDMockito.given(address.getAddressInfo()).willReturn("12345 BOSTON");

        // act and assert
        Employee employee = new Employee("sang", address);
        Assertions.assertThat(employee.getEmployeeInfo()).isEqualTo("SANG LIVES AT 12345 BOSTON");

        // verify
        BDDMockito.verify(address, BDDMockito.times(1)).getAddressInfo();
    }
}