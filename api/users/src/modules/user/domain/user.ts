import { Image } from 'src/modules/shared'

export interface User {
  id: string
  gender?: string,
  firstName?: string
  lastName?: string
  email: string
  birthdate?: string
  image?: Image
  password: string
  phone?: string,
}
