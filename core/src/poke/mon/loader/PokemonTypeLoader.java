package poke.mon.loader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import poke.mon.pokemon.PokemonTypeManipulator;
import poke.mon.pokemon.PokemonTypes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;



public class PokemonTypeLoader {
	
	private XmlReader reader = new XmlReader();
	private Element element;
	private Array<Element> elements;
	private String name;
	private String resistance;
	private String weaknesses;
	private String immunities;
	private ArrayList<PokemonTypes> weakness = new ArrayList<PokemonTypes>();
	private ArrayList<PokemonTypes> resistant = new ArrayList<PokemonTypes>();
	private ArrayList<PokemonTypes> immunity = new ArrayList<PokemonTypes>();
	private static ArrayList<PokemonTypeManipulator> typesets = new ArrayList<PokemonTypeManipulator>();
	private String[] modify;
	
	public PokemonTypeLoader() {
		try {
			element = reader.parse(Gdx.files.internal("data/Types.xml"));
			elements = element.getChildrenByName("type");
			
			for (Element types : elements) { //loops through all the elements that contains "type"
				//Integer.parseInt(types.getAttribute("id"));
				name = types.getAttribute("name");
				//We do not need to add empty tags for what is under this comment, adding a null check would be good
				if (types.getChildByName("weaknesses") != null) {
					weaknesses = types.getChildByName("weaknesses").getAttribute("types");
					modify = weaknesses.split(",");
					if (modify != null) {
						for (int i = 0; i < modify.length; i++) {
							weakness.add(PokemonTypes.UNKOWN.getTypeByString(modify[i]));							
						}
					}
				}
				if (types.getChildByName("immunities") != null) {
					immunities = types.getChildByName("immunities").getAttribute("types");
					modify = immunities.split(",");
					if (modify != null) {
						for (int i = 0; i < modify.length; i++) {
							immunity.add(PokemonTypes.UNKOWN.getTypeByString(modify[i]));
						}
					}
				}
				if (types.getChildByName("resistance") != null) {
					resistance = types.getChildByName("resistance").getAttribute("types");
					modify = resistance.split(",");
					if (modify != null) {
						for (int i = 0; i < modify.length; i++) {
							resistant.add(PokemonTypes.UNKOWN.getTypeByString(modify[i]));
						}
					}
				}
				PokemonTypeManipulator typing = new PokemonTypeManipulator(PokemonTypes.UNKOWN.getTypeByString(name), weakness, resistant, immunity);
				typesets.add(typing);
			}
		} catch (IOException e) {
//			new ExceptionHandler(this.getClass().getName(), "Was unable to locate types.xml");
		}
	}
	
	public static Collection<PokemonTypeManipulator> getInstance() {
		return Collections.unmodifiableCollection(typesets);
	}
}