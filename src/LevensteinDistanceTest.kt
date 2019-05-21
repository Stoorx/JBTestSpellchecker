fun main() {
    assert(DamerauLevensteinDistance.getDistance("кекс", "вес") == 2)
    assert(DamerauLevensteinDistance.getDistance("собака", "бабка") == 3)
    assert(DamerauLevensteinDistance.getDistance("кекс", "кокс") == 1)
}