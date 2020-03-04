package sample;
import java.util.*;
import java.util.Scanner;

public class ImmoESI {
    public static Proprietaire propriospec;
    public static TreeSet<Bien> liste_des_biens =new TreeSet<Bien>(); //liste des biens de l'agence
    private static TreeSet<Bien> biens_archives =new TreeSet<Bien>(); //liste des biens archivés
    public static LinkedList<Messages>  liste_messages=new LinkedList<Messages>();
    protected LinkedList<Administrateur> administrateurs=new LinkedList<Administrateur>();
    public static void setProprietaires(TreeSet<Proprietaire> proprietaires) {
        ImmoESI.proprietaires = proprietaires;
    }

    public static TreeSet<Proprietaire> proprietaires =new TreeSet<Proprietaire>(); //liste de proprietaires

    public ImmoESI(TreeSet<Bien> liste_des_biens, TreeSet<Bien> biens_archives, TreeSet<Proprietaire> proprietaires) {
        this.liste_des_biens = liste_des_biens;
        this.biens_archives = biens_archives;
        this.proprietaires = proprietaires;
    }

    public ImmoESI() {

    }
   public Bien AjouterMaison(Proprietaire proprietaire, TypeDeTransaction transaction) throws SuperficieHabitableException, SurfaceNulleNegativeException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Informations relatives au bien : ");
        System.out.println("Adresse : "); String adresse =sc.nextLine(); //sc.nextLine();
        System.out.println("Wilaya ");
        Wilaya wilaya =Enum.valueOf(Wilaya.class, sc.next().toLowerCase()); sc.nextLine();
        System.out.println("Superficie du bien : "); float surface=sc.nextFloat(); sc.nextLine();
        if(surface<=0) throw new SurfaceNulleNegativeException();
        System.out.println("Prix : "); float prix=sc.nextFloat(); sc.nextLine();
        System.out.println("Ce bien est-il negociable ? ");
        String nego=sc.nextLine(); //sc.nextLine();
        boolean negociable;
        negociable= nego.equalsIgnoreCase("oui");
        System.out.println("Descriptif du bien "); String descriptif=sc.nextLine(); //sc.nextLine();
        System.out.println("Photos :(Entrez le lien URL vers l'album photos"); String photo=sc.nextLine(); //sc.nextLine();
        Date date = new Date();
        System.out.println("Nombre d'etages : "); int nbr_etages=sc.nextInt(); sc.nextLine();
        System.out.println("Nombre de pieces : "); int nbr_pieces=sc.nextInt(); sc.nextLine();
        System.out.println("Cette maison contient-elle meublee ? "); String jar=sc.nextLine(); //sc.nextLine();
        boolean meuble;
        meuble= jar.equalsIgnoreCase("oui"); //sc.nextLine();
        System.out.println("Cette maison contient-elle un jardin ? ");  jar=sc.nextLine(); //sc.nextLine();
        boolean jardin;
        jardin= jar.equalsIgnoreCase("oui"); //sc.nextLine();
        System.out.println("Cette maison contient-elle une piscine ? "); String pis=sc.nextLine();
        // sc.nextLine();
        boolean piscine;
        piscine= jar.equalsIgnoreCase("oui");
        System.out.println("Cette maison contient-elle un garage ? "); String gar=sc.nextLine(); //sc.nextLine();
        boolean garage;
        garage= jar.equalsIgnoreCase("oui");
        System.out.println("Surface habitable "); float surface_habitable=sc.nextFloat(); sc.nextLine();
        //Creation de l'objet
        if(surface < surface_habitable) throw new SuperficieHabitableException();

        Bien nouveau= new Maison(adresse,wilaya,surface,proprietaire,transaction,prix,negociable,descriptif,date,photo,nbr_pieces,meuble,nbr_etages,garage,jardin,piscine,surface_habitable);
        ImmoESI.liste_des_biens.add(nouveau);
        return  nouveau;
    }
    public Bien AjouterAppart(Proprietaire proprietaire, TypeDeTransaction transaction) throws SurfaceNulleNegativeException, BienExistantException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Informations relatives au bien : ");
        System.out.println("Adresse : "); String adresse =sc.nextLine();
        System.out.println("Wilaya ");
        Wilaya wilaya =Enum.valueOf(Wilaya.class, sc.next().toLowerCase());
        System.out.println("Superficie du bien : "); float surface=sc.nextFloat();
        if(surface<=0){
            throw new SurfaceNulleNegativeException();
        }

        System.out.println("Prix : "); float prix=sc.nextFloat(); sc.nextLine();
        System.out.println("Ce bien est-il negociable ? "); String nego=sc.nextLine();
        boolean negociable;
        negociable= nego.equalsIgnoreCase("oui");
        System.out.println("Descriptif du bien "); String descriptif=sc.nextLine();
        System.out.println("Nombre de pieces : "); int nbr_pieces=sc.nextInt(); sc.nextLine();
        System.out.println("Cette maison contient-elle meublee ? "); String jar=sc.nextLine(); //sc.nextLine();
        boolean meuble;
        meuble= jar.equalsIgnoreCase("oui"); //sc.nextLine();
        System.out.println("Photos :(Entrez le lien URL vers l'album photos"); String photo=sc.nextLine();
        Date date = new Date(); //Date d'ajout
        System.out.println("A quelle étage se situe le bien? "); int etage=sc.nextInt();
        sc.nextLine();
        System.out.println("Ce bien est-il un duplexe ? "); String dup=sc.nextLine();
        boolean duplexe;
        duplexe= dup.equalsIgnoreCase("oui");
        Bien nouveau = new Appartement(adresse,wilaya,surface,proprietaire,transaction,prix,negociable,descriptif,date,photo,nbr_pieces,meuble,etage,duplexe);
        if ( liste_des_biens.contains(nouveau) ) {throw new BienExistantException();}

        return  nouveau;
    }
    private Bien AjouterTerrain(Proprietaire proprietaire, TypeDeTransaction transaction) throws SurfaceNulleNegativeException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Informations relatives au bien : ");
        System.out.println("Adresse : "); String adresse =sc.nextLine();
        System.out.println("Wilaya ");
        Wilaya wilaya =Enum.valueOf(Wilaya.class, sc.next().toLowerCase());
        System.out.println("Superficie du bien : "); float surface=sc.nextFloat();
        if(surface<=0) throw new SurfaceNulleNegativeException();
        System.out.println("Prix : "); float prix=sc.nextFloat(); sc.nextLine();
        System.out.println("Ce bien est-il negociable ? "); String nego=sc.nextLine();
        boolean negociable;
        negociable= nego.equalsIgnoreCase("oui");
        System.out.println("Descriptif du bien "); String descriptif=sc.nextLine();
        System.out.println("Photos :(Entrez le lien URL vers l'album photos"); String photo=sc.nextLine();
        Date date = new Date(); //Date d'ajout
        System.out.println("Nombre de façades du bien : "); int nbr_facades=sc.nextInt(); sc.nextLine();
        System.out.println("Etat juridique : "); String etat_juridique=sc.nextLine();
        return new Terrain(adresse,wilaya,surface,proprietaire,transaction,prix,negociable,descriptif,date,photo,nbr_facades,etat_juridique);
    }
    public Bien ajouterBien(Administrateur admin) throws SuperficieHabitableException {
        Scanner sc = new Scanner(System.in);
        Bien nouveau = null;

        System.out.println("Le type du bien a ajouter : Maison, Appartement, Terrain ");
        String type_bien = sc.nextLine();
        System.out.println("Le type de transaction ");
        TypeDeTransaction transaction =Enum.valueOf(TypeDeTransaction.class, sc.next().toLowerCase());
        System.out.println("Proprietaire du bien");
        sc.nextLine();
        System.out.println("Adresse du proprietaire "); String adresse_prop=sc.nextLine();
        System.out.println("Nom du proprietaire "); String nom=sc.nextLine();
        System.out.println("Prenom du proprietaire: "); String prenom=sc.nextLine();
        System.out.println("Numero de telephone "); String num_tel=sc.nextLine();
        System.out.println("Adresse mail :"); String mail=sc.nextLine();
        Proprietaire proprietaire=new Proprietaire(nom,num_tel,prenom,mail,adresse_prop);
        if (type_bien.equalsIgnoreCase("maison")) {
            try {
                nouveau = AjouterMaison(proprietaire, transaction);
            }catch (SuperficieHabitableException | SurfaceNulleNegativeException e){
                System.out.println("Superficie invalide");
            }
            liste_des_biens.add(nouveau); //Utiliser un hashSet supprime la possibilité de doublons
            proprietaires.add(proprietaire);
            //Ajouter le bien à la liste des biens du proprietaires
            proprietaire.liste_proprietees.add(nouveau);
        } else {
            if (type_bien.equalsIgnoreCase("appartement")) {
                try {
                    nouveau = AjouterAppart(proprietaire, transaction);
                } catch (SurfaceNulleNegativeException e) {
                    e.printStackTrace();
                } catch (BienExistantException e) {
                    System.out.println("surface erronee");
                }
                if(liste_des_biens.contains(nouveau)) System.out.println("Ce bien existe deja");
                liste_des_biens.add(nouveau);
                proprietaires.add(proprietaire);
                //Ajouter le bien à la liste des biens du proprietaires
                proprietaire.liste_proprietees.add(nouveau);
            } else {
                if (type_bien.equalsIgnoreCase("terrain")) {
                    try {
                        nouveau = AjouterTerrain(proprietaire, transaction);
                    } catch (SurfaceNulleNegativeException e) {
                        e.printStackTrace();
                    }
                    if(liste_des_biens.contains(nouveau)) System.out.println("Ce bien existe deja");
                    liste_des_biens.add(nouveau);
                    proprietaires.add(proprietaire);
                    proprietaire.liste_proprietees.add(nouveau);
                } else {
                    System.out.println("Type de bien invalide! ");
                }
            }
        }
        return nouveau;
    }
    public static void afficher_liste_des_bien(){
       // int cpt=1;
        for(Bien ele:liste_des_biens){
           // System.out.println("NUMERO DU BIEN : "+cpt);
            ele.afficher();
            System.out.println("---------------------------------------");
            //cpt++;
        }
    }
    public void afficher_liste_des_bien_archives(){
        //int cpt=1;
        for(Bien ele:biens_archives){
          //  System.out.println("NUMERO DU BIEN : "+cpt);
            ele.afficher();
            System.out.println("---------------------------------------");
            //cpt++;
        }
    }
    public void archiver_bien(Administrateur admin,Bien archive){

        biens_archives.add(archive);
        /*Supprimer de la liste des biens*/
        boolean removed=ImmoESI.liste_des_biens.remove(archive);
    }
    public void supprimer_bien(Administrateur admin,Bien supp){
        boolean removed=this.liste_des_biens.remove(supp);
    }
    public void ajouterBien(Administrateur admin, Bien o){
        liste_des_biens.add(o);
        o.proprietaire.liste_proprietees.add(o);
    }
    public static void envoyerMessage(Bien o, String message){
        Messages nouveau=new Messages(o,message);
        ImmoESI.liste_messages.add(nouveau);
    }
    public static void afficherMessages(Administrateur administrateur){
        Iterator<Messages> iterator= liste_messages.iterator();
        while (iterator.hasNext()){
            Messages it=iterator.next();
            it.afficher();
        }
    }
    public void modifierBien(Administrateur administrateur, Bien bien){
        bien.modifierattributs();
    }
    public Bien choisirBien(int numerodubien){
        int cpt=0; Bien bien=null;
        Iterator<Bien> it=liste_des_biens.iterator();
        while (it.hasNext()&&cpt!=numerodubien){
            cpt++;
            bien=it.next();
        }
        return bien;
    }
    public boolean seconnecter(Administrateur administrateur){
        if(this.administrateurs.contains((administrateur))) return true;
        else return false;
    }


}