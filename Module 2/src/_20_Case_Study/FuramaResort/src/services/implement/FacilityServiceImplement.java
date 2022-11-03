package services.implement;

import models.facility.House;
import models.facility.Room;
import models.facility.Villa;
import services.IFacilityService;
import utils.implement.HouseReadAndWriteFileCSV;
import utils.implement.RoomReadAndWriteFileCSV;
import utils.implement.VillaReadAndWriteFileCSV;

import java.util.*;

import static views.DisplayMenu.displayFacilitySubMenuAdd;

public class FacilityServiceImplement implements IFacilityService {
    private static final Map<String, List> facilityListMap = new LinkedHashMap<>();
    static {
        List<Villa> villaList = VillaReadAndWriteFileCSV.readFileCSV();
        List<House> houseList = HouseReadAndWriteFileCSV.readFileCSV();
        List<Room> roomList = RoomReadAndWriteFileCSV.readFileCSV();
        facilityListMap.put("Villa", villaList);
        facilityListMap.put("House", houseList);
        facilityListMap.put("Room", roomList);
    }

    @Override
    public Map<String, List> findAll() {
        return facilityListMap;
    }

    @Override
    public void addNewService() {
        int choice;
        do {
            displayFacilitySubMenuAdd();
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addNewVillaDetail();
                    break;
                case 2:
                    addNewHouseDetail();
                    break;
                case 3:
                    addNewRoomDetail();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice!!! Please try again!!!");
            }
        } while (choice != 4);
    }

    @Override
    public void addNewVillaDetail() {
        Scanner scanner = new Scanner(System.in);
        double usableArea, poolArea, rentalCost;
        int maxCapacity, floors;
        do {
            System.out.print("Enter an usable area: ");
            usableArea = Double.parseDouble(scanner.nextLine());
            if (!validateArea(usableArea)) {
                System.err.println("Usable area must be larger than 30!! Please try again!!!");
            }
        } while (!validateArea(usableArea));

        do {
            System.out.print("Enter a rental cost: ");
            rentalCost = Double.parseDouble(scanner.nextLine());
            if (!validateRentalCost(rentalCost)) {
                System.err.println("Rental cost must be positive value!! Please try again!!!");
            }
        } while (!validateRentalCost(rentalCost));

        do {
            System.out.print("Enter max capacity: ");
            maxCapacity = Integer.parseInt(scanner.nextLine());
            if (!validateMaxCapacity(maxCapacity)) {
                System.err.println("Capacity must be larger than 0 and smaller than 20");
            }
        } while (!validateMaxCapacity(maxCapacity));

        System.out.print("Enter rental type: ");
        String rentalType = scanner.nextLine();
        System.out.print("Enter room standard: ");
        String roomStandard = scanner.nextLine();
        do {
            System.out.print("Enter pool area: ");
            poolArea = Double.parseDouble(scanner.nextLine());
            if (!validateArea(poolArea)) {
                System.err.println("Pool area must be larger than 30!! Please try again!!!");
            }
        } while (!validateArea(poolArea));

        do {
            System.out.print("Enter number of floors: ");
            floors = Integer.parseInt(scanner.nextLine());
            if (!validateNumberOfFloors(floors)) {
                System.err.println("Number of floors must be positive value!! Please try again!!!");
            }
        } while (!validateNumberOfFloors(floors));

        Villa newVilla = new Villa();
        String serviceName = getServiceNameByServiceType("Villa");
        newVilla.setServiceName(serviceName);
        newVilla.setUsableArea(usableArea);
        newVilla.setRentalCost(rentalCost);
        newVilla.setMaxCapacity(maxCapacity);
        newVilla.setRentalType(rentalType);
        newVilla.setRoomStandard(roomStandard);
        newVilla.setPoolArea(poolArea);
        newVilla.setFloors(floors);

        List newList = facilityListMap.get("Villa");
        newList.add(newVilla);
        VillaReadAndWriteFileCSV.writeFileCSV(newList);
        facilityListMap.put("Villa", newList);
    }

    @Override
    public void addNewHouseDetail() {
        Scanner scanner = new Scanner(System.in);
        double usableArea, rentalCost;
        int maxCapacity, floors;
        do {
            System.out.print("Enter an usable area: ");
            usableArea = Double.parseDouble(scanner.nextLine());
            if (!validateArea(usableArea)) {
                System.err.println("Usable area must be larger than 30!! Please try again!!!");
            }
        } while (!validateArea(usableArea));

        do {
            System.out.print("Enter a rental cost: ");
            rentalCost = Double.parseDouble(scanner.nextLine());
            if (!validateRentalCost(rentalCost)) {
                System.err.println("Rental cost must be positive value!! Please try again!!!");
            }
        } while (!validateRentalCost(rentalCost));

        do {
            System.out.print("Enter max capacity: ");
            maxCapacity = Integer.parseInt(scanner.nextLine());
            if (!validateMaxCapacity(maxCapacity)) {
                System.err.println("Capacity must be larger than 0 and smaller than 20");
            }
        } while (!validateMaxCapacity(maxCapacity));

        System.out.print("Enter rental type: ");
        String rentalType = scanner.nextLine();
        System.out.print("Enter room standard: ");
        String roomStandard = scanner.nextLine();
        do {
            System.out.print("Enter number of floors: ");
            floors = Integer.parseInt(scanner.nextLine());
            if (!validateNumberOfFloors(floors)) {
                System.err.println("Number of floors must be positive value!! Please try again!!!");
            }
        } while (!validateNumberOfFloors(floors));

        House newHouse = new House();
        String serviceName = getServiceNameByServiceType("House");
        newHouse.setServiceName(serviceName);
        newHouse.setUsableArea(usableArea);
        newHouse.setRentalCost(rentalCost);
        newHouse.setMaxCapacity(maxCapacity);
        newHouse.setRentalType(rentalType);
        newHouse.setRoomStandard(roomStandard);
        newHouse.setFloors(floors);

        List newList = facilityListMap.get("House");
        newList.add(newHouse);
        HouseReadAndWriteFileCSV.writeFileCSV(newList);
        facilityListMap.put("House", newList);
    }

    @Override
    public void addNewRoomDetail() {
        Scanner scanner = new Scanner(System.in);
        double usableArea, rentalCost;
        int maxCapacity;
        do {
            System.out.print("Enter an usable area: ");
            usableArea = Double.parseDouble(scanner.nextLine());
            if (!validateArea(usableArea)) {
                System.err.println("Usable area must be larger than 30!! Please try again!!!");
            }
        } while (!validateArea(usableArea));

        do {
            System.out.print("Enter a rental cost: ");
            rentalCost = Double.parseDouble(scanner.nextLine());
            if (!validateRentalCost(rentalCost)) {
                System.err.println("Rental cost must be positive value!! Please try again!!!");
            }
        } while (!validateRentalCost(rentalCost));

        do {
            System.out.print("Enter max capacity: ");
            maxCapacity = Integer.parseInt(scanner.nextLine());
            if (!validateMaxCapacity(maxCapacity)) {
                System.err.println("Capacity must be larger than 0 and smaller than 20");
            }
        } while (!validateMaxCapacity(maxCapacity));

        System.out.print("Enter rental type: ");
        String rentalType = scanner.nextLine();
        System.out.print("Enter free service included: ");
        String freeServiceIncluded = scanner.nextLine();

        Room newRoom = new Room();
        String serviceName = getServiceNameByServiceType("Room");
        newRoom.setServiceName(serviceName);
        newRoom.setUsableArea(usableArea);
        newRoom.setRentalCost(rentalCost);
        newRoom.setMaxCapacity(maxCapacity);
        newRoom.setRentalType(rentalType);
        newRoom.setFreeServiceIncluded(freeServiceIncluded);

        List newList = facilityListMap.get("Room");
        newList.add(newRoom);
        RoomReadAndWriteFileCSV.writeFileCSV(newList);
        facilityListMap.put("Room", newList);
    }

    @Override
    public String getServiceNameByServiceType(String serviceType) {
        String serviceName = null;
        switch (serviceType) {
            case "Villa":
                List<Villa> villaList = facilityListMap.get("Villa");
                if (villaList.size() < 9) {
                    serviceName = "SVVL-000" + (villaList.size() + 1);
                } else {
                    serviceName = "SVVL-00" + (villaList.size() + 1);
                }
                break;
            case "House":
                List<House> houseList = facilityListMap.get("House");
                if (houseList.size() < 9) {
                    serviceName = "SVHO-000" + (houseList.size() + 1);
                } else {
                    serviceName = "SVHO-00" + (houseList.size() + 1);
                }
                break;
            case "Room":
                List<Room> roomList = facilityListMap.get("Room");
                if (roomList.size() < 9) {
                    serviceName = "SVRO-000" + (roomList.size() + 1);
                } else {
                    serviceName = "SVRO-00" + (roomList.size() + 1);
                }
                break;
        }
        return serviceName;
    }

    @Override
    public boolean validateArea(double area) {
        return (area >= 30);
    }

    @Override
    public boolean validateRentalCost(double rentalCost) {
        return (rentalCost > 0);
    }

    @Override
    public boolean validateMaxCapacity(int maxCapacity) {
        return (maxCapacity > 0) && (maxCapacity < 20);
    }

    @Override
    public boolean validateNumberOfFloors(int floors) {
        return (floors > 0);
    }

    @Override
    public void displayAll() {
        System.out.println("List of facilities: ");
        Iterator<Map.Entry<String, List>> entries = facilityListMap.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, List> entry = entries.next();
            System.out.println("Service type: " + entry.getKey());
            List list = entry.getValue();
            for (Object facility : list) {
                System.out.println(facility);
            }
            System.out.println();
        }
    }

}
