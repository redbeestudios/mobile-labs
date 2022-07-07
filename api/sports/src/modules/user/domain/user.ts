import { Image } from 'src/modules/shared'

export interface User {
  id: string
  firstName: string
  lastName: string
  email: string
  age: number
  image: Image
  passowrd: string
}
