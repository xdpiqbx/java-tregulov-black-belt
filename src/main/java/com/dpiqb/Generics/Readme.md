# Generics

- Type Safe & Reusable Code

---

- `<?>`
- `<? extends X>`
- `<? super X>`

---

`class Pair<V1, V2 extends Number>{...}`
`class SameTypePair<V>{...}`

---

`public <T> T getFirstElement(ArrayList<T> a1){...}`
`public static <T extends Number&Comparable&Function> T getLastElement(ArrayList<T> a1){...}`

---

`static void showListInfo(List<?> list){...}`
`static void showListInfo(List<? super Number> list){...}`

## Type erasure

Remember about generic methods `Overloading` and `Overriding`
