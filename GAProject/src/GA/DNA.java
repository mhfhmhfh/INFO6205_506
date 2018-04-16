/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GA;

/**
 *
 * @author zinanwang
 */
public class DNA {

    private String key;
    private int    val;

    DNA( String key, int val ) {
        this.key = key;
        this.val = val;
    }

    public String getKey() {
        return key;
    }

    public int  getVal() {
        return val;
    }

    public static String getKey( int val ) {
        String k = null;
        switch( val ) {
            case 0: k = "A";
                break;
            case 1: k = "T";
                break;
            case 2: k = "C";
                break;
            case 3: k = "G";
            default:
                break;
        }
        return k;
    }

}

