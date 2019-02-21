package practice.springframework.sfgpetclinic.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import practice.springframework.sfgpetclinic.model.Owner;
import practice.springframework.sfgpetclinic.services.OwnerSerivce;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    private OwnerSerivce ownerSerivce;

    @InjectMocks
    private OwnerController ownerController;

    private MockMvc mockMvc;

    private Set<Owner> ownerSet = new HashSet<>();

    @BeforeEach
    void setUp() {
        ownerSet.add(Owner.builder().id(1L).firstName("Joly").build());
        ownerSet.add(Owner.builder().id(2L).firstName("Peter").build());

        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }

    @Test
    public void findAllList() throws Exception {
        when(ownerSerivce.findAll()).thenReturn(ownerSet);

        mockMvc.perform(get("/owners"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", ownerSet));
    }
}
