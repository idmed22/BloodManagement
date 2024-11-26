import { BloodGroup } from "./enums/BloodGroup";
import { Gender } from "./enums/Gender";

export class Recipient {
    id!: number;
    name!: string;
    gender!: Gender;
    age!: number;
    address!: string;
    benefitDate!: Date;
    bloodGroup!: BloodGroup;
    contactNumber!: string
    urgent?: boolean 

    constructor(){}
}