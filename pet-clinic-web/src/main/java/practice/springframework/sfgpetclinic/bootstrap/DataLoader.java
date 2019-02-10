package practice.springframework.sfgpetclinic.bootstrap;

import practice.springframework.sfgpetclinic.model.Owner;
import practice.springframework.sfgpetclinic.model.Pet;
import practice.springframework.sfgpetclinic.model.PetType;
import practice.springframework.sfgpetclinic.model.Specialty;
import practice.springframework.sfgpetclinic.model.Vet;
import practice.springframework.sfgpetclinic.model.Visit;
import practice.springframework.sfgpetclinic.services.OwnerSerivce;
import practice.springframework.sfgpetclinic.services.PetTypeService;
import practice.springframework.sfgpetclinic.services.SpecialtyService;
import practice.springframework.sfgpetclinic.services.VetService;
import practice.springframework.sfgpetclinic.services.VisitService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerSerivce ownerSerivce;

    private final VetService vetService;

    private final PetTypeService petTypeService;

    private final SpecialtyService specialtyService;

    private final VisitService visitService;

    public DataLoader(OwnerSerivce ownerSerivce, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerSerivce = ownerSerivce;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        petTypeService.save(cat);

        System.out.println("Loaded petType...");

        Specialty radiology = new Specialty();
        radiology.setDescription("radiology");
        specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("surgery");
        specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("dentistry");
        specialtyService.save(dentistry);

        System.out.println("Loaded specialty...");

        Owner owner1 = Owner.builder()
                .firstName("Michael")
                .lastName("Weston")
                .address("Miami")
                .city("New York")
                .telephone("0101111111")
                .build();

        Pet pet1 = new Pet();
        pet1.setPetType(dog);
        pet1.setBirthDate(LocalDate.now());
        pet1.setName("Rosco");
        pet1.setOwner(owner1);

        owner1.getPets().add(pet1);
        ownerSerivce.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glan");

        ownerSerivce.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Angelina");
        owner3.setLastName("Joliy");

        Pet pet2 = new Pet();
        pet2.setPetType(cat);
        pet2.setBirthDate(LocalDate.now());
        pet2.setName("Fiona");
        pet2.setOwner(owner3);

        owner3.getPets().add(pet2);

        ownerSerivce.save(owner3);

        System.out.println("Loaded owner...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(surgery);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Elena");
        vet2.setLastName("Blank");
        vet2.getSpecialties().add(dentistry);
        vet2.getSpecialties().add(radiology);

        vetService.save(vet2);

        System.out.println("Loaded vet...");

        Visit visit1 = new Visit();
        visit1.setDate(LocalDate.now().minusMonths(3));
        visit1.setDescription("Sneeze kitty");
        visit1.setPet(pet1);

        visitService.save(visit1);

        Visit visit2 = new Visit();
        visit2.setDate(LocalDate.now());
        visit2.setDescription("Sneeze kitty");
        visit2.setPet(pet1);

        visitService.save(visit2);
    }
}
