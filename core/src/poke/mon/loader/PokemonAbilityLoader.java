package poke.mon.loader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import poke.mon.pokemon.PokemonAbilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;

public class PokemonAbilityLoader {
	
	private static ArrayList<PokemonAbilities> abilities = new ArrayList<PokemonAbilities>();
	private XmlReader reader = new XmlReader();
	private Element element;
	private Array<Element> elements;

	public PokemonAbilityLoader() {
		try {
			element = reader.parse(Gdx.files.internal("data/abilities.xml"));
			elements = element.getChildrenByName("ability");
			int id = 0;
			String name;
			String description;
			for (Element abili : elements) {
				id++;
				name = abili.getChildByName("name").getAttribute("value");
				description = abili.getChildByName("description").getAttribute("value");
				
			//	if (description.contains("&qout;")) {
				//	description.replaceAll(regex, replacement);
			//	}
				
				PokemonAbilities ability = new PokemonAbilities(id, name, description);
				abilities.add(ability);
			}
		} catch (IOException e) {
//			new ExceptionHandler(this.getClass().getName(), "Was unable to locate types.xml");
		}
	}
	
	public static Collection<PokemonAbilities> getInstance() {
		return Collections.unmodifiableCollection(abilities);
	}
}
