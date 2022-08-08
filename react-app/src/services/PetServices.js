import { hostNameUrl } from "../config/api";
import axios from "axios";

export const findPets = () => {
  return axios.get(`${hostNameUrl}/api/v1/security`);
};