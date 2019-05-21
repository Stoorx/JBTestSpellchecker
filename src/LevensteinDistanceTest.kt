fun main() {
    assert(LevensteinDistance.getDistance("кекс", "вес") == 2)
    assert(LevensteinDistance.getDistance("собака", "бабка") == 3)
    assert(LevensteinDistance.getDistance("кекс", "кокс") == 1)
}