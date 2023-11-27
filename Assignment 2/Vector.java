import javax.swing.*;
import java.util.Arrays;

public class Vector {
    private double[] doubElements;

    public Vector(double[] _elements) {
        //TODO Task 1.1
        this.doubElements = _elements;
    }

    public double getElementatIndex(int _index) {
        //TODO Task 1.2
        if (_index >= 0 && _index < doubElements.length) {
            return doubElements[_index];
        } else return -1;
    }

    public void setElementatIndex(double _value, int _index) {
        //TODO Task 1.3
        if (_index >= 0 && _index < doubElements.length) {
            doubElements[_index] = _value;
        } else doubElements[doubElements.length - 1] = _value;
    }

    public double[] getAllElements() {
        //TODO Task 1.4
        return doubElements;
    }

    public int getVectorSize() {
        //TODO Task 1.5
        return doubElements.length;
    }

    public Vector reSize(int _size) {
        //TODO Task 1.6
        if (_size <= 0 || _size == getVectorSize()) {
            return Vector.this;
        } else if (_size < getVectorSize()) {
            double[] rsArr = new double[_size];
            for (int i = 0; i < _size; i++) {
                rsArr[i] = this.doubElements[i];
            }
            return new Vector(rsArr);
        } else {
            double[] rsArr = new double[_size];
            for (int j = 0; j < getVectorSize(); j++) {
                rsArr[j] = this.doubElements[j];
            }
            for (int k = getVectorSize(); k < _size; k++) {
                rsArr[k] = -1;
            }
            return new Vector(rsArr);
        }
    }

    public Vector add(Vector _v) {
        //TODO Task 1.7
        if (_v.getVectorSize() > getVectorSize()) {
            double[] array = reSize(_v.getVectorSize()).getAllElements();
            for (int i = 0; i < array.length; i++) {
                array[i] += _v.getElementatIndex(i);
            }
            return new Vector(array);
        } else if (_v.getVectorSize() < getVectorSize()) {
            double[] array = _v.reSize(this.getVectorSize()).getAllElements();
            for (int i = 0; i < getVectorSize(); i++) {
                array[i] += doubElements[i];
            }
            return new Vector(array);
        } else {
            for (int i = 0; i < getVectorSize(); i++) {
                doubElements[i] += _v.doubElements[i];
            }
        }
        return Vector.this;
    }

    public Vector subtraction(Vector _v) {
        //TODO Task 1.8
        if (_v.getVectorSize() > getVectorSize()) {
            double[] array = reSize(_v.getVectorSize()).getAllElements();
            for (int i = 0; i < array.length; i++) {
                array[i] -= _v.getElementatIndex(i);
            }
            return new Vector(array);
        } else if (_v.getVectorSize() < getVectorSize()) {
            _v.reSize(this.getVectorSize());
            double[] array = getAllElements();
            for (int i = 0; i < getVectorSize(); i++) {
                array[i] -= _v.getElementatIndex(i);
            }
            return new Vector(array);
        } else {
            for (int i = 0; i < getVectorSize(); i++) {
                doubElements[i] -= _v.doubElements[i];
            }
        }
        return Vector.this;
    }

    public double dotProduct(Vector _v) {
        //TODO Task 1.9
        double dp = 0;
        if (_v.getVectorSize() < getVectorSize()) {
            double[] arrVector = _v.reSize(getVectorSize()).getAllElements();
            double[] arrCopy = getAllElements();
            double[] dotPdct = new double[getVectorSize()];
            for (int i = 0; i < arrCopy.length; i++) {
                dotPdct[i] = arrCopy[i] * arrVector[i];
            }
            for (double x : dotPdct) {
                dp += x;
            }
            return dp;
        } else if (_v.getVectorSize() > getVectorSize()) {
            double[] resizeArr = reSize(_v.getVectorSize()).getAllElements();
            for (int i = 0; i < resizeArr.length; i++) {
                dp += resizeArr[i] * _v.doubElements[i];
            }
            return dp;
        } else {
            double[] dotPdct = new double[getVectorSize()];
            for (int i = 0; i < getVectorSize(); i++) {
                dotPdct[i] = doubElements[i] * _v.doubElements[i];
            }
            for (double x : dotPdct) {
                dp += x;
            }
        }
        return dp;
    }

    public double cosineSimilarity(Vector _v) {
        //TODO Task 1.10
        double var1 = 0;
        double var2 = 0;
        if (_v.getVectorSize() < getVectorSize()) {
            double[] arrVector = _v.reSize(getVectorSize()).getAllElements();
            double[] arrCopy = getAllElements();
            for (int i = 0; i < getVectorSize(); i++)
            {
                var1 += arrCopy[i] * arrCopy[i];
                var2 += arrVector[i] * arrVector[i];
            }
        }
        else if (_v.getVectorSize() > getVectorSize())
        {
            double[] resizeArr = reSize(_v.getVectorSize()).getAllElements();
            for (int i = 0; i < _v.getVectorSize(); i++)
            {
                var1 += resizeArr[i] * resizeArr[i];
                var2 += _v.getElementatIndex(i) * _v.getElementatIndex(i);
            }
        }
        else
        {
            for (int i = 0; i < getVectorSize(); i++)
            {
                var1 += getElementatIndex(i) * getElementatIndex(i);
                var2 += _v.getElementatIndex(i) * _v.getElementatIndex(i);
            }
        }
        double DotPdct = dotProduct(_v);
        var1 = Math.sqrt(var1);
        var2 = Math.sqrt(var2);
        return DotPdct/ (var1*var2);
    }

    @Override
    public boolean equals(Object _obj) {
        Vector v = (Vector) _obj;
        boolean boolEquals = true;
        //TODO Task 1.11
        if (Arrays.equals(v.doubElements,this.doubElements)) {
        return boolEquals;
        }
            else {
            boolEquals = false;
        }
        return boolEquals;
    }

    @Override
    public String toString() {
        StringBuilder mySB = new StringBuilder();
        for (int i = 0; i < this.getVectorSize(); i++) {
            mySB.append(String.format("%.5f", doubElements[i])).append(",");
        }
        mySB.delete(mySB.length() - 1, mySB.length());
        return mySB.toString();
    }
}
