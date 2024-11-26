import { Donor } from "./Donor"
import { BloodGroup } from "./enums/BloodGroup"
import { RequestStatus } from "./enums/RequestStatus"

export class Request {
    id!: number
    recipientId!: number 
    requestDate!: Date
    bloodGroup!: BloodGroup
    isUrgent!: boolean
    status!: RequestStatus;

   
}