import { hostNameUrl } from "../config/api";
import axios from "axios";

export const registerUser = async (signupDetails) => {
  console.log("Entered");
  const { data } = await axios.post(
    `${hostNameUrl}/api/v1/auth/signup`,
    signupDetails
  );
  console.log(data);
  return { data };
};