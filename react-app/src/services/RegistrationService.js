import { hostNameUrl } from "../config/api";
import axios from "axios";

export const registerUser = async (signupDetails) => {
  const { data } = await axios.post(
    `${hostNameUrl}/api/v1/auth/signup`,
    signupDetails
  );
  return { data };
};