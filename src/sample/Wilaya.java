package sample;

public enum Wilaya {
    adrar(1,10000),
    chlef(2,24560),
    laghouat(3,10100),
    oumelbouaghi(4,10200),
    batna(5,60000),
    bejaia(6,22000),
    biskra(7,25000),
    bechar(8,26000),
    blida(9,70000),
    bouira(10,36000),
    tamanrasset(11,24500),
    tebessa(12,24850),
    tlemcen(13,56320),
    tiaret(14,14750),
    tiziOuzou(15,60000),
    alger(16,30000),
    djelfa(17,55000),
    djijel(18,21000),
    setif(18,100000),
    saida(20,47000),
    skikda(21,48600),
    sidiBelAbbes(22,68000),
    annaba(23,24800),
    guelma(24,27000),
    constantine(25,65000),
    medea(26,52000),
    mostaganem(27,24800),
    msila(28,24800),
    mascara(29,42300),
    ouargla(30,52300),
    oran(31,12300),
    elbayadh(32,25314),
    illizi (33,42500),
    bordjbouarreridj (34,15478),
    boumerdes (35,65400),
    eltarf (36,85200),
    tindouf(37,75000),
    tissemsilt (38,245100),
    eloued (39,24500),
    khenchela (40,45863),
    soukahras (41,14263),
    tipaza (42,14523),
    mila (43,24150),
    aindefla(44,15763),
    naama(45,24856),
    ainTemouchent (46,47263),
    ghardaia(47,86231),
    relizane(48,12345);
    public final int matricule;
    public final float prixMetreCarre;
    Wilaya(int matricule, float prixMetreCarre){
        this.matricule=matricule;
        this.prixMetreCarre=prixMetreCarre;
    }
    public int getMatricule(){
        return matricule;
    }
    public float getPrixMetreCarre(){
        return prixMetreCarre;
    }

}
