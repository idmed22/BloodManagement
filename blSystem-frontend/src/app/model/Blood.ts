import { BloodGroup } from "./enums/BloodGroup";
import { BloodStatus } from "./enums/BloodStatus";
import { BloodType } from "./enums/BloodType";

export class Blood {
    id!: number;
    type!: BloodGroup;
    component!: BloodType;
    collectionDate!: Date;
    expiryDate!: Date;
    status!: BloodStatus;
}