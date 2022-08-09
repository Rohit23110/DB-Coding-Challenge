import { hostNameUrl } from "../config/api";
import axios from "axios";

export const findTradesforBook = async (id) => {
  const resp = await axios.get(`${hostNameUrl}/api/v1/book/${id}/trades`);
  console.log(resp.data);
  return resp;
};

export const findTradesforBond = async (id) => {
  const resp = await axios.get(`${hostNameUrl}/api/v1/tradesforsecurity/${id}`);
  console.log(resp.data);
  return resp;
};
