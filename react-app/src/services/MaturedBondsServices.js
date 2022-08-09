import { hostNameUrl } from "../config/api";
import axios from "axios";

export const findBondsPastMaturityDate = async () => {
  const { data } = await axios.get(
    `${hostNameUrl}/api/v1/securitiesPastMaturityDate`
  );
  return { data };
};
