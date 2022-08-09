import { hostNameUrl } from "../config/api";
import axios from "axios";

export const findBonds = async () => {
  const { data } = await axios.get(`${hostNameUrl}/api/v1/security`);
  return { data };
};
