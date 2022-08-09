import { hostNameUrl } from "../config/api";
import axios from "axios";

export const loginUser = async (loginDetails) => {
  const { data } = await axios.post(
    `${hostNameUrl}/api/v1/auth/login`,
    loginDetails
  );
  return { data };
};