import { BloodGroup } from "./enums/BloodGroup";
import { Gender } from "./enums/Gender";

export class Donor {
    id!: number;
    name!: string;
    gender!: Gender;
    age!: number;
    address!: string;
    bloodGroup!: BloodGroup;
    contactNumber!: string;
    lastDonationDate! : Date;
    eligible?: boolean 

    constructor() {}
  }
  